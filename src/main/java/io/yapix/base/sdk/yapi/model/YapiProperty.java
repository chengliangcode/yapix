package io.yapix.base.sdk.yapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.Set;

/**
 * 参数
 */
public class YapiProperty {

    /** 类型 */
    private String type;

    /** 描述 */
    private String description;

    /** 是否必须 */
    private Set<String> required;

    @SerializedName("default")
    private String defaultValue;

    /** 当type为object */
    private Map<String, YapiProperty> properties;

    /** 当type为array */
    private YapiProperty items;

    /** 当type为array, item元素是否唯一 */
    private Boolean uniqueItems;

    /** 当type为array, 最小元素个数 */
    private Integer minItems;

    /** 当type为array, 最大元素个数 */
    private Integer maxItems;

    /** 响应mock */
    private YapiMock mock;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getRequired() {
        return required;
    }

    public void setRequired(Set<String> required) {
        this.required = required;
    }

    public Map<String, YapiProperty> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, YapiProperty> properties) {
        this.properties = properties;
    }

    public YapiProperty getItems() {
        return items;
    }

    public void setItems(YapiProperty items) {
        this.items = items;
    }

    public YapiMock getMock() {
        return mock;
    }

    public void setMock(YapiMock mock) {
        this.mock = mock;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getUniqueItems() {
        return uniqueItems;
    }

    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    public Integer getMinItems() {
        return minItems;
    }

    public void setMinItems(Integer minItems) {
        this.minItems = minItems;
    }

    public Integer getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(Integer maxItems) {
        this.maxItems = maxItems;
    }
}


