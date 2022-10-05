package lwhat.dao.code;

import java.util.List;

import lwhat.dto.CodeTableDTO;
import lwhat.service.code.CodeService;

public interface CodeDAO extends CodeService {
	public List<CodeTableDTO> codeList() throws Exception ;

}
