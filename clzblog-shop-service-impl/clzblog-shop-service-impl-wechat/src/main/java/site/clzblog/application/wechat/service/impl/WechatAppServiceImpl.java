package site.clzblog.application.wechat.service.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import site.clzblog.application.wechat.entity.AppEntity;
import site.clzblog.application.wechat.service.WechatAppService;

@RestController
public class WechatAppServiceImpl implements WechatAppService {

	@Override
	@GetMapping("get/app")
	public AppEntity getApp() {
		return new AppEntity("58790713", "chengli.zou");
	}

}
