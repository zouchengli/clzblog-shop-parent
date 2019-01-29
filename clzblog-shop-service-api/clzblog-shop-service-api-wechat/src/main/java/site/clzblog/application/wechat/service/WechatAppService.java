package site.clzblog.application.wechat.service;
import org.springframework.web.bind.annotation.GetMapping;

import site.clzblog.application.wechat.entity.*;

public interface WechatAppService {
	@GetMapping("get/app")
	AppEntity getApp();
}
