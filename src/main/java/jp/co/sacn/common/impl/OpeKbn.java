package jp.co.sacn.common.impl;

import jp.co.sacn.common.Decoder;
import jp.co.sacn.common.Encodable;

/**
 * 操作区分の列挙型クラス.
 *
 */
public enum OpeKbn implements
                     Encodable<Integer> {

    /** 勤怠登録 */
    OPEKBN01(1, "勤怠登録"),
    /** 勤怠一括登録 */
    OPEKBN02(2, "勤怠一括登録");

    /** デコーダー */
    private static final Decoder<Integer, OpeKbn> DECODER = Decoder.create(values());

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
    private OpeKbn(Integer code, String name) {
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
    public static OpeKbn decode(Integer code) {
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
