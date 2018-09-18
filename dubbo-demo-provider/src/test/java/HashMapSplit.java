import java.util.HashMap;
import java.util.Map;

/**
 * @author maple 2018.09.12 上午10:44
 */
public class HashMapSplit {
    /**
     * Doctor 健康检查
     * <p>
     * <p>
     * {"gcInfos":{"gcInfos":"0/0"},"flows":{},"service":"com.today.api.order.service.OrderService2","container_info":" shutdown/terminating/terminated[false/false/false] -activeCount/poolSize[3/100] -waitingTasks/completeTasks/totalTasks[0/95255/95258]","serviceInfo":{},"tasks":{"waitingQueue":0,"total":95258,"succeed":95255},"errors":{}}
     *
     * @return diagnoseMap
     */
    public static void main(String[] args) {
//        {"gcInfos":{"gcInfos":"0/0"},"flows":{},"service":"com.today.api.order.service.OrderService2","container_info":" shutdown/terminating/terminated[false/false/false] -activeCount/poolSize[1/100] -waitingTasks/completeTasks/totalTasks[0/320151/320152]","serviceInfo":{},"tasks":{"waitingQueue":0,"total":320152,"succeed":320151},"errors":{}}
        String echoInfo = "echoInfo";
        Map<String, Object> diagnoseMap = diagnoseReport();
        diagnoseMap.put("container_info", echoInfo);

        StringBuilder builder = new StringBuilder();
        builder.append("{");


        diagnoseMap.forEach((k, v) -> {
            builder.append("\"").append(k).append("\"").append(":");
            if (v instanceof Map) {
                builder.append('{');
                ((Map) v).forEach((x, y) -> {
                    builder.append("\"").append(x).append("\"").append(":")
                            .append("\"").append(y).append("\"").append(",");


                });
                builder.setCharAt(builder.length() - 1, '}');
            } else {
                builder.append("\"").append(v).append("\"");
            }
            builder.append(",");
        });
        builder.setCharAt(builder.length() - 1, '}');


        String log = builder.toString();


        System.out.println(log);

    }

    private static Map<String, Object> diagnoseReport() {
        Map<String, Object> diagnoseMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        Map tasksInfo = mapTasksInfo();
        Map gcInfo = mapGCInfo();
        Map flowsInfo = mapFlows();
        Map errorsInfo = mapErrors();
        diagnoseMap.put("tasks", tasksInfo);
        diagnoseMap.put("gcInfos", gcInfo);
        diagnoseMap.put("flows", flowsInfo);
        diagnoseMap.put("errors", errorsInfo);


        map.put("dalao", 2);
        map.put("dalao1", 3);

        diagnoseMap.put("serviceInfo", map);
        return diagnoseMap;
    }


    private static Map<String, Object> mapTasksInfo() {
        Map<String, Object> taskMap = new HashMap<>(4);
        taskMap.put("waitingQueue", "1");
        taskMap.put("succeed", "2");
        taskMap.put("total", "3");
        return taskMap;
    }

    private static Map<String, String> mapGCInfo() {
        Map<String, String> gdMap = new HashMap<>(4);
        gdMap.put("gcInfos", "0/0");
        return gdMap;
    }


    /**
     * flow信息
     *
     * @return
     */
    private static Map<String, Object> mapFlows() {
        Map<String, Object> flowMap = new HashMap<>(8);
        int i = 2;
        if (i > 0) {
            flowMap.put("lastMinuteMax", 2);
            flowMap.put("lastMinuteMin", 3);
            flowMap.put("lastMinuteAvg", 4);
        }
        return flowMap;
    }

    /**
     * 错误条目
     *
     * @return
     */
    private static Map<String, Object> mapErrors() {
        Map<String, Object> errorsMap = new HashMap<>(8);
        errorsMap.put("error", 2);
        return errorsMap;
    }


}
