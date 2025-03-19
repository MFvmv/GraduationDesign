package com.hospital.search.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode
@Document(indexName = "patients")
@Setting(shards = 1,replicas = 0)
public class EsPatients implements Serializable {
    @ApiModelProperty(value = "病人唯一标识")
    @Id
    private Integer patientID;
    @ApiModelProperty(value = "病人姓名")
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "出生日期")
    private Date dateOfBirth;
    @ApiModelProperty(value = "联系电话")
    private String contactNumber;
    @ApiModelProperty(value = "紧急联系人")
    private String emergencyContact;
    @ApiModelProperty(value = "创建时间")
    private Date createdAt;
    @ApiModelProperty(value = "身份证号")
    private String id_card_number;
    @ApiModelProperty(value = "证件类型")
    private String id_card_type;
    @ApiModelProperty(value = "证件有效期")
    private Date id_card_expiry;
    @ApiModelProperty(value = "地址")
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String address;

}
