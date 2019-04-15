package com.d1m.elasticsearch.domain.enums;

import org.apache.commons.lang3.StringUtils;

public enum EstoreCodeEnum {


    SYSTEM_ERROR(0, "系统异常"),
    SUCCESS(1, "操作成功"),
    INVALID_REQUEST_PARAMS(2,"请求参数不合法"),
    DB_OPERATION_ERROR(3, "数据库操作异常"),
    NO_PERMISSION(403, "无权限"),
    ILLEGAL_REQUEST(105, "非法请求"),
    LOGIN_ERROR(106, "小程序登录失败"),
    GET_TOKEN_ERROR(107, "获取TOKEN失败"),
    CONSUME_CARD_ERROR(108, "核销卡券失败"),
    GET_CARDCODE_ERROR(109, "获取卡券CODE失败"),
    CARD_BACKGROUND_NOT_EXIST(110, "卡券背景不存在"),
    /**
     * Order module,80000
     */
    POPUP_BONUS_ITEM_OUT_STOCK(8000,"赠品库存不够"),
    POPUP_OUT_STOCK(8001,"库存不够"),
    POPUP_ORDER_SMS_NOTIFY(8002,"订单短信通知"),
    POPUP_ORDER_SMS_NOT_NOTIFY(8003,"订单不需要短信通知"),
    ORDER_HAS_PAY(8004,"订单已经支付"),
    PAY_PARAM_INVALID(8005,"支付参数不合法"),
    PAY_SYSTEM_ERROR(8006,"支付系统异常"),
    PAY_SYSTEM_PARAMS_INVALID(8007,"支付返回参数不合法"),
    ORDER_NOT_EXSIST(8008,"订单不存在"),
    PAY_CONFIG_ERROR(8009,"后台配置错误"),

    SMS_CONTENT_INVALID(8010,"短信发送内容不合法"),
    SMS_IDS_NOT_EMPTY(8011,"订单号不能为空"),
    SMS_SEND_FAILURE(8012,"短信发送不成功"),
    PAY_NOTIFY_ERROR(8013,"支付异步调用异常"),
    GOODS_HAS_ORDER(8014,"该商品已经存在订单了"),
    GOODS_LIMIT_COUNT(8015,"该商品限购"),
    GOODS_IS_CLOSED(8016,"该商品已经下架"),
    GOODS_NOT_EXIST(8017,"该商品不存在"),
    USER_lOW_LEVEL(8018,"用户级别不够"),
    PAY_AMOUNT_INVALID(8019,"支付金额有误"),

    CART_NOT_EXIST(8020,"购物车信息不存在"),

    SMS_VERIFY_CODE_ERROR(8021,"短信验证码错误"),
    SMS_VERIFY_LIMIT_ERROR(8023,"短信时间限制"),
    ORDER_CANT_CANCEL(8021,"订单不可取消"),
    SMS_PHONE_DECODE_ERROR(8024,"手机解码错误"),
    SMS_PHONE_FORMAT_ERROR(8025,"手机号格式"),
    SMS_PHONE_LIMIT_CODE_ERROR(8026,"手机号验证码已验证"),
    SMS_PHONE_EMPTY(8027,"手机号不存在"),
    SMS_PHONE_OVER_TIME(8028,"手机号验证码超时"),

    ORDER_NO_PRODUCT(8029,"需先添加商品"),
    CART_LIMIT(8030,"购物车限制"),
    GOODS_NOT_PAY(8031,"有未支付订单"),

    MEMBER_NO_UPDATE(8031,"信息未更新"),
    MEMBER_DECODE_ERROR(8032,"用户信息解密失败"),
    MEMBER_WISH_GOODS_NOT_EXIST(8033,"心愿单数据不存在"),
    MEMBER_WISH_GOODS_EXIST(8034,"心愿单已添加"),

    INVOICE_EXIST(8035,"发票已经存在"),

    MSG_WRONGFUL(8036,"发送内容不合法"),
    TEMPLATE_ERROR(8037,"模板消息发送error"),

    WISH_NO_ERROR(8037,"心愿单商品数量不对"),

    SMS_VERIFY_OUT_ERROR(8038,"手机号验证码超出允许次数"),
    CAMPAIGN_NOT_BEGIN(8039,"活动未开始"),
    PRODUCT_QUANTITY_ERROR(8040,"商品数量错误"),
    CAMPAIGN_IS_FINISH(8041,"活动已经结束"),
    ORDER_CANCELED(8042,"订单取消"),
    COUPON_CANT_BE_USED(8043,"优惠券不可用"),
    COUPON_CAN_NOT_FOUND(8044,"查询不到该优惠券"),
    COUPON_IS_EMPTY(8045,"用户可用优惠券为空"),
    PACKAGE_PRICE_PARSE_ERROR(8047,"解析礼包装出错"),
    USER_DECODE_INFO_ERROR(8048,"用户签名解析出错"),
    COUPON_TEMPLATE_MEMBER_GROUP_IS_NOT_EXIST(8049,"用户未在优惠券组内"),



    OMS_ESTORE_PARAM_EMPTY(9001,"公共参数为空"),
    OMS_ESTORE_PARAM_ERROR(9002,"公共参数错误"),
    OMS_ESTORE_SERVICE_PARAM_EMPTY(9003,"业务参数错误"),
    OMS_ESTORE_ORDERID_EMPTY(9004,"订单编号不存在"),
    OMS_NO_SKU_NOT_SENDOUT(9005,"没有未发货的sku"),
    OMS_NO_SKU_REFUND(9006,"没有未退款的sku"),

    ESTORE_SERVICE_ERROR_NOT_FUND(7000,"微服务连接不能被找到"),
    CRM_REGIST_ERROR(7000,"crm注册失败"),

    MOBILE_ALREADY_BOOK(7001,"该手机号已经预约"),
    OPENID_ALREADY_BOOK(7002,"该微信已经预约"),
    UNION_ID_IS_NULL(7003,"unionId为空"),
    CRM_NOT_REGISTER(7004,"crm未注册"),
    CRM_CUSTOMER_ID_NULL(7005,"CUSTOMER_ID 为空"),
    CRM_RETURN_ERROR(7006,"返回信息错误"),
    CRM_MEMBER_EXIST_AND_MINI_PROGRAMME_EXIST(7007,"CRM存在此注册用户，小程序也存在此用户，数据进行同步"),
    CRM_MEMBER_EXIST_AND_MINI_PROGRAMME_NOT_EXIST(7008,"CRM存在此注册用户，小程序不存在此用户，数据进行创建"),



    REFUND_QUANTITY_GET_LIMIT(10001,"退款单数量达到上限"),
    REFUND_AMOUNT_GET_LIMIT(10002,"退款单金额达到上限"),
    WECHAT_REFUND_FAIL(10003,"微信退款申请失败"),

    BOOK_INFO_NOT_FOUND(10003,"预定信息为空"),
    OUT_OF_STOCK(10004,"没有库存"),
    MOBILE_ALREADY_EXIST(10005,"手机号已存在"),
    MEMBER_NOT_EXIST(10006,"用户不存在"),
    OLD_PASSWD_ERROR(10007,"旧密码错误"),
    TWO_PASSWD_DIFFERENT(10008,"两次密码不相同"),
    LEADS_INFO(99999,"LEADS INFO"),

    SALES_ASSISTANT_EXIST(11001,"该店员已经注册"),
    SALES_ASSISTANT_STATUS_ERROE(11002,"该店员状态错误"),
    SALES_ASSISTANT_NOT_EXIST(11003,"不存在该店员"),
    SALES_ASSISTANT_NUMBER_EXIST(11004,"该店员编号已经存在"),

    APPLY_INVOICE_EXPIRED(12000,"开票时间超时"),
    APPLY_INVOICE_NOT_ALLOW(12001,"订单不允许开票"),
    ;



    private Integer code;
    private String desc;

    EstoreCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 根据desc查找enum
     * @param desc
     * @return
     */
    public static EstoreCodeEnum getCodeByDesc(String desc){
        if(StringUtils.isEmpty(desc)) return null;
        for(EstoreCodeEnum t : EstoreCodeEnum.values()){

            if(desc.equals(t.toString())){
                return t;
            }
        }
        return null;
    }
}