package com.study;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Goods {
	@Id
	@NotBlank
	private String id;

	@NotEmpty(message="名前は空白ではなく、フルネームで入力して下さい")
	private String name;

	@Min(0)
	private Integer price;
}
