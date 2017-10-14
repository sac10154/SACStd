package jp.co.sacn.controller.config;

import jp.co.sacn.controller.common.DownloadController;
import jp.co.sacn.service.config.DownloadAttendanceCsvFileParams;
import jp.co.sacn.service.config.DownloadAttendanceCsvFileService;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

public class DownloadAttendanceCsvFileController extends DownloadController {

	/** Service */
    private DownloadAttendanceCsvFileService service = new DownloadAttendanceCsvFileService();

    /** パラメータ */
    private DownloadAttendanceCsvFileParams params = new DownloadAttendanceCsvFileParams();


    @Override
    public Navigation run() throws Exception {
    	BeanUtil.copy(request, params);

    	// ファイル名
    	String filename = new String();
    	filename = params.getUserId() + "_" +params.getCalendarMonth() + ".csv";

    	// CSVデータ
    	String str = new String();
    	str = service.getCsvData(params);

    	// ダウンロード
    	return download(filename,str);
    }
}
