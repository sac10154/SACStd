package jp.co.sacn.common.impl;

import jp.co.sacn.common.Decoder;
import jp.co.sacn.common.Encodable;

/**
 * 性別の列挙型クラス.
 *
 */
public enum Gender implements
                     Encodable<Integer> {

    /** 男 */
    MALE(1, "男"),
    /** 女 */
    FEMALE(2, "女");

    /** デコーダー */
    private static final Decoder<Integer, Gender> DECODER = Decoder.create(values());

    /** コード値 */
    private final Integer code;

    /** 名称 */
    private final String name;

    /**
     * コンストラクタ.
     *
     * @param code コード値
     * @param name 名称
     */
    private Gender(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    /**
     * コード値からEnumクラスを取得する.
     *
     * @param code コード値
     * @return 受領形式Enumクラス
     */
    public static Gender decode(Integer code) {
        return DECODER.decode(code);
    }

    /**
     * 名称を取得するメソッド.
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }
}
