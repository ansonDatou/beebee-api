package com.quwan.beebee.exception;

/**
 * 响应代码
 * 1 公共：0 - 599
 * 2 Common模块：600 - 699
 * 3 Archives模块：700 - 799
 * 4 Topic模块：800 - 899
 * 5 User模块：900 - 999
 */
public enum ErrorCode {
    Successful(0, "Successful"),
    Unknown(1, "Unknown"),
    ServerError(2, "Server error"),
    ParameterMissing(3, "Parameter Missing"),
    SignFail(4, "Sign Fail"),
    RequestTimeout(5, "Request Timeout"),
    AuthcodeFail(600, "Authcode Validate Fail"),
    AliYunSmsErroe(601, "AliYunSmsError"),
    ArchivesParamNull(700, "Archives Param Null"),
    InsertFail(701, "Insert Fail"),
    NoMoreComments(702, "No More Comments"),
    FailedObtainDetails(800, "Failed Obtain Details"),
    TheKeyValueConflict(801, "The Key Value Conflict"),
    FailedVote(802, "Failed Vote"),
    TheTypeValueNull(803, "The Type Value Null"),
    NoLoginPleaseLogin(804,"No Login, Please Login"),
    UserVoteExist(805, "User Vote Exist"),
    NoMoreBarrage(806, "No More Barrage"),
    MobileRegistered(900, "Mobile Registered"),
    MobileUnregistered(901, "The Mobile Unregistered"),
    PasswordFail(902, "The Password Fail"),
    UserIsNull(903, "User Is Null"),
    OldPasswordFail(904, "The Old Password Fail"),
    SignedInToday(905, "Signed in today"),
	NOThisArchive(906, "There is no this Archive"),
    UserIsNotExist(907,"There is no this User"),
    UserParamIsError(908, "User Param Is Error"),
    AmountCountNotEnough(909,"integral is not enough"),
    NotExistThisGoods(910,"not exist this goods"),
    AlreadyJoinedBlacklist(911,"already joined blacklist"),
    NoExistBlackList(912, "no exist blacklist");
    
    public int code;
    public String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取对应的ErrorCode
     */
    public static ErrorCode getErrorCode (int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.code == code) {
                return errorCode;
            }
        }

        return ErrorCode.Unknown;
    }
}
