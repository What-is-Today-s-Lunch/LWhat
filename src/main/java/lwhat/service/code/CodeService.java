package lwhat.service.code;

import java.util.List;

import lwhat.dto.CodeTableDTO;
import lwhat.service.LWhatService;

public interface CodeService extends LWhatService {
	public CodeTableDTO codeView(String codevalue) throws Exception ;
}
