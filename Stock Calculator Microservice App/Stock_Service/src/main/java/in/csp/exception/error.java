package in.csp.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class error {
	private LocalDateTime ldt;
	private String errorMsg;
	private String status;
}
