package site.clzblog.application.member.service.feign;

import org.springframework.cloud.openfeign.FeignClient;

import site.clzblog.application.wechat.service.WechatAppService;

@FeignClient(name = "app-clzblog-wechat")
public interface WechatAppServiceFeign extends WechatAppService {
}
