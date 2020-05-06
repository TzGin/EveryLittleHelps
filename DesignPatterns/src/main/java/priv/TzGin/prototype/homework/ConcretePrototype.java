package priv.TzGin.prototype.homework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

/**
 * 用JSON方式实现一个原型模式的深克隆，并画出UML图
 */
@Data
public class ConcretePrototype {

    private int age;
    private String name;
    private List<String> hobbies;

    public ConcretePrototype deepClone() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            byte[] json = objectMapper.writeValueAsBytes(this);
            return objectMapper.readValue(json, ConcretePrototype.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
