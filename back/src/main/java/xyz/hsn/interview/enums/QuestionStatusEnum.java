package xyz.hsn.interview.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum QuestionStatusEnum {
    INIT(0,"创建"),
    FAIL(1,"审核失败"),
    SUCCESS(2,"审核通过"),
    ;
    @EnumValue
    @JsonValue
    public Integer code;
    public String value;
    QuestionStatusEnum(Integer code,String value){
        this.code = code;
        this.value = value;
    }

    public static QuestionStatusEnum getByStatus(Integer code){
        QuestionStatusEnum[] values = values();
        for (QuestionStatusEnum statusEnum : values) {
            if (statusEnum.code.equals(code)){
                return statusEnum;
            }
        }
        return null;
    }


}
