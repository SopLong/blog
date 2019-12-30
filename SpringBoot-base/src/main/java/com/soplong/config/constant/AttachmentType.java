package com.soplong.config.constant;

public enum AttachmentType {
    ARTICLE_COVER("ARTICLE_PICTURE","博客封面");

    private String type;

    private String desc;

    AttachmentType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
