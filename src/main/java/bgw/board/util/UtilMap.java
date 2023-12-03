package bgw.board.util;

import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UtilMap {

    @Getter
    private final static UtilMap instance = new UtilMap();

    private UtilMap(){
    }
    public Map<String,Object> getPageParam(){
        return new HashMap<>(){
            {
                put("countRow",10);
                put("startRow" ,0);
            }
        };
    }
    public void getPageParam(Map<String,Object> map) {

        Object rowCount = map.get("rowCount");
        Object page = map.get("page");
        int rowCountInt = 0;
        int startRow = 0;
        int pageInt = 0;
        Optional<Object> rowOpt = Optional.ofNullable(rowCount);
        Optional<Object> pageOpt = Optional.ofNullable(page);

        if (rowOpt.isEmpty()) {
            map.put("countRow", 10);
        } else {
            if (rowCount instanceof String) {
                String rowCountStr = StringUtils.isEmpty((String) rowCount) ? "10" : (String) rowCount;
                rowCountInt = Integer.valueOf(rowCountStr);
                map.put("countRow", Integer.valueOf(rowCountStr));
            } else if (rowCount instanceof Number) {
                rowCountInt = ((Number) rowCount).intValue();
                rowCountInt = rowCountInt == 0 ? 10 : rowCountInt;
                map.put("countRow", rowCountInt);
            }
        }
        if (pageOpt.isEmpty()) {
            map.put("startRow", startRow);
        } else {
            if (page instanceof String) {
                String pageStr = StringUtils.isEmpty((String) page) ? "0" : (String) page;
                pageInt = Integer.valueOf(pageStr);
                if(pageInt>=0){
                    startRow = rowCountInt*(pageInt-1);
                }
                map.put("startRow", startRow);
            } else if (page instanceof Number) {
                pageInt = ((Number) page).intValue();
                pageInt = pageInt == 0 ? 0 : pageInt;
                if(pageInt>=0){
                    startRow = rowCountInt*(pageInt-1);
                }
                map.put("startRow", startRow);
            } else {
                map.put("startRow", startRow);
            }
        }
    }
}
