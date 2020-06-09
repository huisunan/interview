package xyz.hsn.interview.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.hsn.interview.constant.Constants;

@Data
@AllArgsConstructor
public class BaseResult {
    private Integer code;
    private String msg;

    public BaseResult() {
    }

    public static BaseResult ok(Integer code, String msg) {

        return new BaseResult(code, msg);
    }

    public static BaseResult ok(String msg) {
        return ok(Constants.SUCCESS, msg);
    }

    public static BaseResult fail(Integer code, String msg) {
        return new BaseResult(code, msg);
    }

    public static BaseResult fail(String msg) {
        return fail(Constants.FAIL, msg);
    }

    public static BaseResult create(boolean flag){
        if (flag){
            return ok("创建成功！");
        }else {
            return fail("创建失败！");
        }
    }

    public static BaseResult update(boolean flag){
        if (flag){
            return ok("更新成功！");
        }else {
            return fail("更新失败！");
        }
    }

    public static BaseResult delete(boolean flag) {
        if (flag){
            return ok("删除成功！");
        }else {
            return fail("删除失败！");
        }
    }
}
