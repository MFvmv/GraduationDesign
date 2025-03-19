package com.hospital.admin.controller;

import com.hospital.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dataAnalysis")
public class DataAnalysisController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 1. 关键指标（本月门诊量、住院人次、总收入）
    @GetMapping("/key-metrics")
    public CommonResult<Map<String, Object>>  getKeyMetrics() {
        String sql = "SELECT * FROM view_key_metrics";
        return CommonResult.success(jdbcTemplate.queryForMap(sql));
    }

    // 2. 门诊量趋势（基于medicalrecords表中的RecordDate字段）
    @GetMapping("/outpatient-trend")
    public CommonResult< List<Map<String, Object>> > getOutpatientTrend() {
        String sql = "SELECT * FROM view_outpatient_trend ORDER BY `日期`";
        return CommonResult.success(jdbcTemplate.queryForList(sql));
    }

    // 3. 收入构成（仅保留药品、住院和门诊，原“检查”重命名为“门诊”）
    @GetMapping("/revenue-composition")
    public CommonResult< List<Map<String, Object>> > getRevenueComposition() {
        String sql = "SELECT * FROM view_revenue_composition";
        return CommonResult.success(jdbcTemplate.queryForList(sql));
    }

    // 4. 月收入趋势
    @GetMapping("/monthly-revenue-trend")
    public CommonResult< List<Map<String, Object>> > getMonthlyRevenueTrend() {
        String sql = "SELECT * FROM view_monthly_revenue_trend ORDER BY `月份`";
        return  CommonResult.success(jdbcTemplate.queryForList(sql));
    }

    // 5. 日收入详情（每日各收入类型的收入及资产量，这里“资产量”指示为每日收入衍生指标）
    @GetMapping("/daily-quantity-change")
    public CommonResult< List<Map<String, Object>> > getDailyIncomeDetails() {
        String sql = "SELECT * FROM view_daily_quantity_change ORDER BY `统计日期`, `类别`";
        return CommonResult.success(jdbcTemplate.queryForList(sql));
    }

    // 6. 床位使用率
    @GetMapping("/bed-usage")
    public CommonResult< Map<String, Object> > getBedUsage() {
        String sql = "SELECT * FROM view_bed_usage";
        return CommonResult.success(jdbcTemplate.queryForMap(sql));
    }
}
