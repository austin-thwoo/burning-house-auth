package com.codingfist.burninghouseskeleton.common.error.model;

public enum ErrorCode {


    NATION_NOT_FOUND(400, "STD001", "해당 국가분류를 찾을 수 없습니다."),
    CERTIFY_NOT_FOUND(400, "STD002", "해당 인증분류를 찾을 수 없습니다."),
    MACHINE_NOT_FOUND(400, "STD003", "해당 기기분류를 찾을 수 없습니다."),
    LINE_NOT_FOUND(400, "STD004", "해당 제품분류를 찾을 수 없습니다."),
    DUPLICATED_STANDARD_NAME(400, "STD005", "중복되는 분류명 입니다."),


    INVALID_INPUT_VALUE(400, "C001", "올바르지 않은 형식입니다."),
    METHOD_NOT_ALLOWED(405, "C002", "지원하지 않는 메소드입니다."),
    ENTITY_NOT_FOUND(400, "C003", "해당 엔티티를 찾을 수가 없습니다."),
    INTERNAL_SERVER_ERROR(500, "C004", "알 수 없는 에러 (서버 에러)"),
    INVALID_TYPE_VALUE(400, "C005", "타입이 올바르지 않습니다."),
    HANDLE_ACCESS_DENIED(403, "C006", "권한이 없습니다."),
    HANDLE_INVALID_TOKEN(401, "C007", "토큰이 없거나 올바르지 않습니다."),
    DATE_WRONG(401, "C008", "비교날짜가 올바르지 않습니다."),


    USER_NOT_FOUND(400, "U000", "해당 유저를 찾을 수 없습니다"),
    DUPLICATED_NICKNAME(500, "U001", "중복된 닉네임 입니다."),
    DUPLICATED_ID(500, "U002", "사용 불가능한 아이디 입니다."),
    DUPLICATED_EMAIL(500, "U003", "사용 불가능한 이메일 입니다."),

    NOT_MATCH_PASSWORD(500, "U004", "비밀번호를 확인 해 주세요"),
    PASSCODE_MIS_MATCH(500, "U005", "인증코드가 일치하지 않습니다."),
    PASSCODE_TIME_OVER(500, "U006", "인증코드가 만료되었습니다."),
    AUTHENTIFICATION_MIS_MATCH(500, "U007", "이메일 인증을 완료하여 주세요."),
    INFO_MIS_MATCH(500, "U008", "잘못된 정보입니다."),
    USER_UNAUTHORISED(500, "U009", "가입인증을 완료후 이용해 주세요."),
    USER_DELETED(500, "U001", "삭제된 아이디입니다."),

    //시험신청
    EXAMINATION_NOT_FOUND(500, "EX001", "해당 시험신청을 찾을 수 없습니다."),
    EXAMINATION_NOT_APPORVE(500, "EX002", "승인된 시험신청이 아닙니다."),
    DOCUMENT_NOT_FOUND(500, "EX003", "해당 성적서를 찾을 수 없습니다."),
    EXAMINATION_NOT_COMPLETE(500, "EX004", "검토완료된 성적서가 아닙니다."),
    DOCUMENT_NOT_CONFIRM(500, "EX005", "검토가 완료되지 않은 성적서가 존재합니다."),
    REFERENCEFILE_MIS_MATCH(500, "EX006", "시험신청에 해당하지 않은 파일이 혹은 요구사항이 존재합니다."),
    REQUIREMENT_MIS_MATCH(500, "EX007", "시험신청에 해당하지 않은 요구사항 존재합니다."),
    EXAMINATION_MIS_MATCH(500, "EX008", "해당 시험에 대한 신청자가 아닙니다."),
    DID_NOT_FOUND(500, "EX009", "DID_ADDRESS를 발급받아 주세요."),


    //company
    COMPANY_NOT_FOUND(500, "CP001", "해당 회사가 존재하지 않습니다."),
    DUPLICATED_SERIALCODE(500, "CP002", "동일한 사업자 번호가 이미 존재합니다."),
    SUBCOMPANY_MIS_MATCH(500, "CP003", "해당 제조자/공장에대한 권한이 없습니다."),
    SUBCOMPANY_DELETED(500, "CP004", "삭제된 제조사/공장 입니다."),
    ALREADY_SUBCOMPANY(500, "CP005", "이미 존재하는 제조사/공장정보 입니다."),


    NOT_FOUND_ITEM(400, "I001", "해당 게시글을 찾을 수 없습니다."),

    NOT_FOUND_ACTIVATION(400, "A001", "해당 인증신청을 찾을 수 없습니다."),
    NOT_FOUND_CARE_RESULT(400, "CR001", "해당 제품케어 결과를 찾을 수 없습니다."),
    NOT_FOUND_COUPON(400, "CP001", "해당 쿠폰을 찾을 수 없습니다."),
    ALREADY_RESISTER_CODE(500, "C002", "이미 초대코드를 입력하셨습니다."),
    NOT_FOUND_ACTIVATION_RESULT(400, "AR001", "해당 정품인증 결과를 찾을 수 없습니다."),


//    NOT_FOUND_CODEUSER(400,"U002","해당 초대코드를 갖은 유저를 찾을 수 없습니다"),

    OVER_POINT(500, "P001", "소지하고 있는 적립금보다 많은 적림금을 사용할 수 없습니다."),
    RESISTER_PAGE(500, "R9721", "회원가입 페이지로 이동"),
    USER_MIS_MATCH(500, "R9721", "로그인한 유저의 정보가 다릅니다.");


    private final int status;
    private final String code;
    private final String message;


    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }


}
