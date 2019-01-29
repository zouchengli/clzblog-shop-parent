package site.clzblog.application.member.service;

import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import site.clzblog.application.member.entity.*;

@Api(tags = "Member service interface")
public interface MemberAppService {
	@GetMapping("member/invoke/wechat")
	@ApiImplicitParam("Member service invoke wechat service")
	AppEntity memberInvokeWechat();
}
