package xyz.hsn.interview.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.hsn.interview.constant.Constants;

@EqualsAndHashCode(callSuper = true)
@Data
public class DataResult extends BaseResult{
    private Object data;

    public static DataResult ok(Object data){
        DataResult dataResult = new DataResult();
        dataResult.setCode(Constants.SUCCESS);
        dataResult.setData(data);
        return dataResult;
    }
}
