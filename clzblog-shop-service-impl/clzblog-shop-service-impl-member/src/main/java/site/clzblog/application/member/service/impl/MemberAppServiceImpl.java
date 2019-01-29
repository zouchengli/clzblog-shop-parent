package site.clzblog.application.member.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import site.clzblog.application.member.entity.AppEntity;
import site.clzblog.application.member.service.MemberAppService;
import site.clzblog.application.member.service.feign.WechatAppServiceFeign;

@RestController
public class MemberAppServiceImpl implements MemberAppService {
	@Autowired
	private WechatAppServiceFeign wechatAppServiceFeign;

	@Override
	@GetMapping("member/invoke/wechat")
	public AppEntity memberInvokeWechat() {
		site.clzblog.application.wechat.entity.AppEntity entity = wechatAppServiceFeign.getApp();
		AppEntity appEntity = new AppEntity();
		BeanUtils.copyProperties(entity, appEntity);
		return appEntity;
	}

}
