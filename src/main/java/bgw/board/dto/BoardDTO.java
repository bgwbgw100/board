package bgw.board.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class BoardDTO {
    private int boardId;
    @NotNull
    private String id;
    @NotNull
    private String title;
    @NotNull
    private String content;

    private LocalDate registDt;

    private LocalDate updateDt;

}
