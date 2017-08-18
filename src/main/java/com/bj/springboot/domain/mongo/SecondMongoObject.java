package com.bj.springboot.domain.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by sunboyu on 2017/8/17.
 */
@Data
@Document(collection = "second_mongo")
@NoArgsConstructor
@AllArgsConstructor
public class SecondMongoObject {

    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
