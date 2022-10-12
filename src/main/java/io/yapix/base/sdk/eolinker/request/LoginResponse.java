package io.yapix.base.sdk.eolinker.request;

public class LoginResponse {

    private String success;

    private String code;

    private String requestId;

    private Data data;

    public static class Data {
        String jwt;

        String rjwt;

        public String getJwt() {
            return jwt;
        }

        public void setJwt(String jwt) {
            this.jwt = jwt;
        }

        public String getRjwt() {
            return rjwt;
        }

        public void setRjwt(String rjwt) {
            this.rjwt = rjwt;
        }
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
