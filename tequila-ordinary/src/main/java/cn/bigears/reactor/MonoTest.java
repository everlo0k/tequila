package cn.bigears.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * MonoTest
 * @author shenyang
 * @date 2025-11-24
 */
public class MonoTest {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("hi");
        mono.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("finish"));
        // 支持多次订阅
        mono.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("finish"));

        // 按照顺序执行多个Mono
        Mono<Void> step = Mono.fromRunnable(() -> {
            System.out.println("do step 1");
        }).then(Mono.fromRunnable(() -> {
            System.out.println("do step 2");
        })).then();
        step.subscribe();

        // 线程调度
        Mono<String> ioBound = Mono.fromCallable(() -> {
            Thread.sleep(100);
            return "IO Result";
        }).subscribeOn(Schedulers.boundedElastic());
        ioBound.subscribe(System.out::println);
        // 阻塞主线程直到 Mono 完成并获取结果
        ioBound.block();

        // publishOn 和 subscribeOn
        Flux.just("tom").map(s -> {
                    System.out.println("[map] Thread name: " + Thread.currentThread().getName());
                    return s.concat("@mail.com");
                })
                .publishOn(Schedulers.newBoundedElastic(4, 4, "thread-publishOn"))
                .filter(s -> {
                    System.out.println("[filter] Thread name: " + Thread.currentThread().getName());
                    return s.startsWith("t");
                })
                .subscribeOn(Schedulers.newBoundedElastic(4, 4, "thread-subscribeOn"))
                .subscribe(s -> {
                    System.out.println("[subscribe] Thread name: " + Thread.currentThread().getName());
                    System.out.println(s);
                });
        // 会等待所有 Mono 完成后，发出完成信号
        Mono<Void> combined = Mono.when(
                Mono.delay(Duration.ofSeconds(1)),
                Mono.delay(Duration.ofSeconds(2))
        );
        combined.subscribe(
                System.out::println,
                System.err::println,
                () -> System.out.println("All tasks completed")
        );

    }

}
