import dayjs from "dayjs";

// export const BASE_API = "http://8.138.45.155:8080";
// export const LOCAL_NETWORK_API = "http://8.138.45.155:8080"
export const BASE_API = "http://localhost:8080";
export const LOCAL_NETWORK_API = "http://localhost:8080"
export const FORM_TYPE={
    'varchar': (num) => num > 20 ?  'TextArea' :'Input',
    'enum':(num)=>'Radio',
    'date': () => 'DatePicker',
    'timestamp': () => 'DatePicker',
    'time': () => 'DatePicker',
    'text':()=> 'TextArea',
    'int':()=>'Input',
    'decimal':()=>'Input'
}

export const TABLE_FILTER_TYPE =[
    {
        math: { jdbcType: "LOCAL_DATE" },
        fun: (prop, value) => value==null?null:dayjs(value).format("YYYY-MM-DD")
        
    },
    {
        math: { jdbcType: "LOCAL_DATE_TIME" },
        fun: (prop, value) => value==null?null:dayjs(value).format("YYYY-MM-DD HH:mm:ss")
    }
]

export const NUMBER_RULES = {
    "rules": [
        {
        "type": /^[0-9]+$/,
        "message": "只能输入数字",
        }
    ]
}
