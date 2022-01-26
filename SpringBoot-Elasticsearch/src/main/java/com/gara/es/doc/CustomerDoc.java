package com.gara.es.es.doc;


import org.springframework.data.annotation.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDateTime;

/**
 * @author GARA
 */
@Document(indexName = "customer")
@Setting(settingPath = "setting/setting.json")
public class CustomerDoc {

    @Id
    @Field(name = "id")
    private Long id;

    @Field(name = "code", type = FieldType.Keyword)
    private String code;

    @Field(name = "level", type = FieldType.Keyword)
    private String level;

    @Field(name = "second_level", type = FieldType.Keyword)
    private String secondLevel;

    @Field(name = "age")
    private Integer age;

    @Field(name = "sex", type = FieldType.Keyword)
    private Integer sex;

    @Field(name = "first_name", type = FieldType.Text, analyzer = "standard")
    private String firstName;

    @Field(name = "first_name", type = FieldType.Text, analyzer = "simple")
    private String lastName;

    @Field(name = "birth_date")
    private LocalDateTime birthDate;

    @CreatedDate
    @Field(name = "create_date")
    private LocalDateTime createDate;

    @LastModifiedDate
    @Field(name = "update_date")
    private LocalDateTime updateDate;

    @CreatedBy
    @Field(name = "created_by")
    private String createdBy;
    
    @LastModifiedBy
    @Field(name = "updated_by")
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(String secondLevel) {
        this.secondLevel = secondLevel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
