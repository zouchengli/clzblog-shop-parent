package site.clzblog.application.wechat.service;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import site.clzblog.application.wechat.entity.*;

@Api(tags="Wechat app service")
public interface WechatAppService {
	@ApiImplicitParam("Get service info")
	@GetMapping("get/app")
	AppEntity getApp();
}
