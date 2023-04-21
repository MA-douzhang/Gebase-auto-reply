package com.yupi.autoreply.monitor;

import cn.hutool.core.util.RandomUtil;
import com.yupi.autoreply.answerer.Answerer;
import com.yupi.autoreply.api.gebaseChat.GebaseApi;
import com.yupi.autoreply.api.zsxq.ZsxqApi;
import com.yupi.autoreply.common.ErrorCode;
import com.yupi.autoreply.config.GebaseConfig;
import com.yupi.autoreply.config.ZsxqConfig;
import com.yupi.autoreply.exception.BusinessException;
import com.yupi.autoreply.model.TaskListItem;
import com.yupi.autoreply.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;

@Slf4j
public class GebaseMonitor extends Monitor {

    private final GebaseApi gebaseApi = SpringContextUtils.getBean(GebaseApi.class);

    private final GebaseConfig gebaseConfig = SpringContextUtils.getBean(GebaseConfig.class);

    public GebaseMonitor(TaskListItem taskListItem) {
        super(taskListItem);
    }
    @Override
    public void onMonitor(Answerer answerer) {
        String taskName = taskListItem.getName();
        log.info("任务 {} 监控开始", taskName);
        WebSocketClient socketChat = gebaseApi.createSocketChat(gebaseConfig.getUrl());
        // 随机缓冲
        try {
            Thread.sleep(1000 + RandomUtil.randomInt(0, 2000));
        } catch (InterruptedException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, e.getMessage());
        }
        log.info("任务 {} 监控结束", taskName);
    }
}
