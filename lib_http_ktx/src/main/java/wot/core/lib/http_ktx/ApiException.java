package wot.core.lib.http_ktx;

/**
 * @Sub 网络
 * @Description 自定义异常
 * @Author Wot.Yang
 * @CreateDate 2022/8/15
 * @Organization: Wot
 */
public class ApiException extends Exception{

    /**
     * 异常code
     */
    public int code;

    public String tMessage;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public ApiException(int code, String message) {
        this.code = code;
        this.tMessage = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return tMessage;
    }

    public void settMessage(String tMessage) {
        this.tMessage = tMessage;
    }
}
