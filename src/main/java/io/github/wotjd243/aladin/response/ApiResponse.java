package io.github.wotjd243.aladin.response;

import io.github.wotjd243.aladin.error.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

    private ApiResponseCode code;
    private String message;
    private T data;

    private ApiResponse(ApiResponseCode status) {
        this.bindStatus(status);
    }

    private ApiResponse(ApiResponseCode status, T data) {
        this.bindStatus(status);
        this.data = data;
    }

    private ApiResponse(ApiResponseCode code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private void bindStatus(ApiResponseCode status) {
        this.code = status;
        this.message = status.getMessage();
    }

    public static <T> ApiResponse<T> createOK(T data) {
        return new ApiResponse<>(ApiResponseCode.OK, data);
    }

    public static ApiResponse createOK() {
        return new ApiResponse<>(ApiResponseCode.OK);
    }

    public static ApiResponse<String> createException(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), "");
    }

    public static ApiResponse<String> createException(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode.getCode(), message, "");
    }

    public static <T> ApiResponse<T> createException(ErrorCode errorCode, T data) {
        return new ApiResponse<>(errorCode.getCode(), data);
    }
}
