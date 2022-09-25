package com.wzg.springcloud.lb;

/**
 * @author whlie(true){learn}
 */
import org.springframework.cloud.client.ServiceInstance;
import java.util.List;

public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
