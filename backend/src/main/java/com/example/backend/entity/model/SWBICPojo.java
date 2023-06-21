package com.example.backend.entity.model;

import com.example.backend.entity.SWBIC;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SWBICPojo {
    private String swBIC;
    private boolean defaultSWBIC;
    public static SWBIC toEntity(SWBICPojo swbicPojo) {
        SWBIC swbic = new SWBIC();
        try {
            BeanUtils.copyProperties(swbic, swbicPojo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return swbic;
    }

    public static SWBICPojo fromEntity(SWBIC swbic){
        SWBICPojo swbicPojo = new SWBICPojo();
        try {
            BeanUtils.copyProperties(swbicPojo, swbic);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return swbicPojo;
    }
}
