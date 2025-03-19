<template>
  <div class="page-container">
    <h2>医院运营数据分析</h2>

    <!-- Key Metrics -->
    <el-row :gutter="20" class="data-cards">
      <el-col :span="8" v-for="metric in keyMetrics" :key="metric.label">
        <el-card shadow="hover" class="metric-card">
          <div class="metric-icon">
            <el-icon><component :is="metric.icon" /></el-icon>
          </div>
          <div class="metric-label">{{ metric.label }}</div>
          <div class="metric-value">{{ metric.value }}</div>
          <div class="metric-trend" :class="metric.trend >= 0 ? 'up' : 'down'">
            {{ Math.abs(metric.trend) }}% {{ metric.trend >= 0 ? '↑' : '↓' }}
          </div>
        </el-card>
      </el-col>
    </el-row>

    <!-- Charts -->
    <el-row :gutter="20" class="chart-row">
      <el-col :span="12">
        <el-card class="chart-card">
          <template #header>
            <div class="chart-header">
              <span>门诊量趋势</span>
            </div>
          </template>
          <div class="chart-container" ref="outpatientChart"></div>
        </el-card>
      </el-col>

      <el-col :span="12">
        <el-card class="chart-card">
          <template #header>
            <div class="chart-header">
              <span>收入构成</span>
            </div>
          </template>
          <div class="chart-container" ref="revenueChart"></div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="20" class="chart-row">
      <el-col :span="12">
        <el-card class="chart-card">
          <template #header>
            <div class="chart-header">
              <span>月收入趋势图</span>
            </div>
          </template>
          <div class="chart-container" ref="monthlyRevenueChart"></div>
        </el-card>
      </el-col>

      <el-col :span="12">
        <el-card class="chart-card">
          <template #header>
            <div class="chart-header">
              <span>床位使用率</span>
            </div>
          </template>
          <div class="chart-container" ref="bedUsageChart"></div>
        </el-card>
      </el-col>
    </el-row>

    <!-- Data Table -->
    <el-card class="data-table-card">
      <template #header>
        <div class="table-header">
          <span>日收入详情</span>
          <el-button type="primary" @click="exportData">导出报表</el-button>
        </div>
      </template>
      <el-table :data="dailyIncomeDetails" style="width: 100%">
        <el-table-column prop="date" label="统计日期" />
        <el-table-column prop="incomeType" label="类别" />
        <el-table-column prop="assetAmount" label="数量变化" />
        <el-table-column prop="dailyIncome" label="日收入" />
      </el-table>
    </el-card>
  </div>
</template>

<script>
import { 
  keyMetrics, 
  outpatientTrend, 
  revenueComposition, 
  monthlyRevenueTrend, 
  dailyQuantityChange, 
  bedUsage 
} from '@/api/dataAnalysis.js'

export default {
  name: 'DataAnalysis',
  components: {

  },
  data() {
    return {
      // 从后端获取的关键指标数据将转换为数组，并添加图标与趋势（此处趋势默认为0，如需计算请调整业务逻辑）
      keyMetrics: [],
      outpatientTrendData: [],
      revenueCompositionData: [],
      monthlyRevenueTrendData: [],
      dailyIncomeDetails: [],
      bedUsageData: {},
      outpatientPeriod: '7d',
      revenuePeriod: 'month',
      charts: {
        outpatient: null,
        revenue: null,
        monthlyRevenue: null,
        bedUsage: null
      },
      selectedBill: {
        id: '',
        patientName: '',
        type: '',
        amount: 0,
        createTime: '',
        status: '',
        items: []
      },
      billDialogVisible: false,
      detailDialogVisible: false,
      selectedDepartment: null
    }
  },
  mounted() {
    this.loadData();
    this.$nextTick(() => {
      this.initOutpatientChart();
      this.initRevenueChart();
      this.initMonthlyRevenueChart();
      this.initBedUsageChart();
      // window.addEventListener('resize', this.handleResize);
    });
  },
  methods: {
    async loadData() {
      try {
        // 1. 加载关键指标数据
        const kmResponse = await keyMetrics();
        
        // 将返回对象转换为数组，补充 trend 和 icon（趋势值可根据需求计算，此处设为0）
        this.keyMetrics = [
          { label: '本月门诊量', value: kmResponse.data['本月门诊量'], trend: 0, icon: 'User' },
          { label: '住院人次', value: kmResponse.data['住院人次'], trend: 0, icon: 'House' },
          { label: '总收入(万元)', value: kmResponse.data['总收入(万元)'], trend: 0, icon: 'Money' }
        ];
        
        // 2. 加载门诊量趋势数据（基于medicalrecords表的RecordDate字段）
        const resOutpatientTrend = await outpatientTrend()
        
        this.outpatientTrendData = resOutpatientTrend.data;

        const resRevenueComposition = await revenueComposition()
        // 3. 加载收入构成数据（收入类型：药品、住院、门诊）
        this.revenueCompositionData = resRevenueComposition.data;

        const resMonthlyRevenueTrend = await monthlyRevenueTrend()
        const filteredData = resMonthlyRevenueTrend.data.filter(item => item["月份"] !== null);
        // 4. 加载月收入趋势数据
        this.monthlyRevenueTrendData = filteredData;

        const resDaily = await dailyQuantityChange();
        // 5. 加载日收入详情数据，并转换字段名称
        const dailyData = resDaily.data

        this.dailyIncomeDetails = dailyData.map(item => ({
          date:item['统计日期'],
          incomeType: item['类别'],
          assetAmount: item['数量变化'],
          dailyIncome: item['日收入']
        }));

        // 6. 加载床位使用率数据
        const resBedUsage =  await bedUsage()
        this.bedUsageData = resBedUsage.data;
        // 数据加载完成后更新图表
        this.updateOutpatientChart();
        this.updateRevenueChart();
        this.updateMonthlyRevenueChart();
        this.updateBedUsageChart();
  
      } catch (error) {
        console.error(error);
      }
    },
    // 初始化并更新门诊量趋势图表
    initOutpatientChart() {
      this.charts.outpatient = this.$echarts.init(this.$refs.outpatientChart);
    },
    updateOutpatientChart() {
      const dates = this.outpatientTrendData.map(item => item['日期']);
      const values = this.outpatientTrendData.map(item => item['门诊量']);
      const option = {
        tooltip: { trigger: 'axis' },
        xAxis: {
          type: 'category',
          data: dates
        },
        yAxis: { type: 'value' },
        series: [
          {
            data: values,
            type: 'line',
            smooth: true,
            areaStyle: { opacity: 0.3 },
            lineStyle: { width: 3 }
          }
        ]
      };
      this.charts.outpatient.setOption(option);
    },
    // 初始化并更新收入构成图表
    initRevenueChart() {
      this.charts.revenue = this.$echarts.init(this.$refs.revenueChart);
    },
    updateRevenueChart() {
      const data = this.revenueCompositionData.map(item => ({
        value: item['收入金额'],
        name: item['收入类型']
      }));
      const option = {
        tooltip: { trigger: 'item' },
        legend: { orient: 'horizontal', bottom: 0 },
        series: [
          {
            name: '收入来源',
            type: 'pie',
            radius: ['40%', '70%'],
            center: ['50%', '45%'],
            label: { show: true, formatter: '{b}: {d}%' },
            data: data
          }
        ]
      };
      this.charts.revenue.setOption(option);
    },
    // 初始化并更新月收入趋势图表
    initMonthlyRevenueChart() {
      this.charts.monthlyRevenue = this.$echarts.init(this.$refs.monthlyRevenueChart);
    },
    updateMonthlyRevenueChart() {
      const months = this.monthlyRevenueTrendData.map(item => item['月份']);
      const values = this.monthlyRevenueTrendData.map(item => item['月收入']);
      const option = {
        tooltip: { trigger: 'axis' },
        xAxis: {
          type: 'category',
          data: months
        },
        yAxis: { type: 'value' },
        series: [
          {
            data: values,
            type: 'line',
            smooth: true,
            areaStyle: { opacity: 0.3 },
            lineStyle: { width: 3 }
          }
        ]
      };
      this.charts.monthlyRevenue.setOption(option);
    },
    // 初始化并更新床位使用率图表
    initBedUsageChart() {
      this.charts.bedUsage = this.$echarts.init(this.$refs.bedUsageChart);
    },
    updateBedUsageChart() {
      const usageRate = this.bedUsageData['床位使用率'] || 0;
      const option = {
        tooltip: { formatter: '{b} <br/>{a}: {c}%' },
        series: [
          {
            name: '使用率',
            type: 'gauge',
            detail: { formatter: '{value}%', fontSize: 20 },
            data: [{ value: usageRate, name: '床位使用率' }],
            axisLine: {
              lineStyle: {
                width: 30,
                color: [
                  [0.3, '#67C23A'],
                  [0.7, '#E6A23C'],
                  [1, '#F56C6C']
                ]
              }
            }
          }
        ]
      };
      this.charts.bedUsage.setOption(option);
    },
    handleResize() {
      Object.values(this.charts).forEach(chart => {
        chart && chart.resize();
      });
    },
    exportData() {
      this.$message.success('数据导出成功');
    },
    handleBillDetail(bill) {
      this.selectedBill = {
        id: bill.id || '001',
        patientName: bill.patientName || '张三',
        type: bill.type || '门诊',
        amount: bill.amount || 1000,
        createTime: bill.createTime || new Date().toISOString().split('T')[0],
        status: bill.status || '已支付',
        items: bill.items || [
          { name: '诊疗费', quantity: 1, price: 50, total: 50 },
          { name: '药品费', quantity: 2, price: 100, total: 200 },
          { name: '检查费', quantity: 1, price: 750, total: 750 }
        ]
      };
      this.billDialogVisible = true;
    },
    handleDetail(row) {
      this.selectedDepartment = row;
      this.detailDialogVisible = true;
    }
  },
  beforeUnmount() {
    Object.values(this.charts).forEach(chart => {
      chart && chart.dispose();
    });
    window.removeEventListener('resize', this.handleResize);
  },
  watch: {
    outpatientPeriod() {
      // 根据周期变化可以在此调用接口更新数据，本示例直接更新图表
      this.updateOutpatientChart();
    },
    revenuePeriod() {
      // 根据周期变化可以在此调用接口更新数据，本示例直接更新图表
      this.updateRevenueChart();
    }
  }
};
</script>

<style>
/* 根据需要添加样式 */
</style>
