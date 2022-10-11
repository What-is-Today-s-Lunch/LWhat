package lwhat.dao.impl.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.RestaurantConstants;
import lwhat.dao.impl.LWhatConnectionDAOImpl;
import lwhat.dto.CodeTableDTO;
import lwhat.service.code.CodeService;
import lwhat.util.ConnectionManager;

public class CodeDAOImpl extends LWhatConnectionDAOImpl implements CodeService {
	@Override
	public CodeTableDTO codeView(String codevalue) throws Exception {
		Connection con = getConnection();
		String sql = RestaurantConstants.restaurant.getProperty("CODE_VIEW_SQL");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, codevalue);
		ResultSet rs = pstmt.executeQuery();
		CodeTableDTO codeviewDTO = new CodeTableDTO();
		if (rs != null && rs.next()) {
			codeviewDTO.setCodeValue(rs.getString("codevalue"));
			codeviewDTO.setCodeName(rs.getString("codeName"));
		}
		ConnectionManager.closeConnection(rs, pstmt, con);
		return codeviewDTO;
	}
}
