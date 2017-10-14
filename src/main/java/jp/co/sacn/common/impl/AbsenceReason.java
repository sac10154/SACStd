package jp.co.sacn.common.impl;

import jp.co.sacn.common.Decoder;
import jp.co.sacn.common.Encodable;

/**
 * 休暇理由の列挙型クラス.
 *
 */
public enum AbsenceReason implements
                     Encodable<Integer> {

    /** 有休 */
    YUKYU(1, "有休"),
    /** 半休 */
    HANKYU(2, "半休"),
    /**  */
    DAIKYU(3, "代休"),
    /** 振休 */
    FURIKYU(4, "振休"),
    /** 振出 */
    FURISYUTSU(5, "振出"),
    /** 休出 */
    KYUSYUTU(6, "休出");

    /** デコーダー */
    private static final Decoder<Integer, AbsenceReason> DECODER = Decoder.create(values());

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
    private AbsenceReason(Integer code, String name) {
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
    public static AbsenceReason decode(Integer code) {
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
