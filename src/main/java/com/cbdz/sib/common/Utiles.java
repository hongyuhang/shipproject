package com.cbdz.sib.common;


import com.cbdz.sib.model.BaseModel;
import java.util.List;

public class Utiles {
    public static void addSeqAttribute(List<? extends BaseModel> models, int offset, int limit) {
        int start = 1 + (offset - 1) * limit;
        for(BaseModel model : models) {
            model.setSeq(start++);
        }
    }
}
