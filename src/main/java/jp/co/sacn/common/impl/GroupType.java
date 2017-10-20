package jp.co.sacn.common.impl;

import jp.co.sacn.common.Decoder;
import jp.co.sacn.common.Encodable;

/**
 * グループ種別の列挙型クラス.
 *
 */
public enum GroupType implements
                     Encodable<Integer> {

    /** グループ */
	GROUP(1, "グループ"),
    /** ロール */
    ROLE(2, "ロール");

    /** デコーダー */
    private static final Decoder<Integer, GroupType> DECODER = Decoder.create(values());

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
    private GroupType(Integer code, String name) {
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
    public static GroupType decode(Integer code) {
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
