package cn.bigears.reactor;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

/**
 * FluxTest
 * @author shenyang
 * @date 2025-11-24
 */
public class FluxTest {

    public static void main(String[] args) {
        Flux<String> flux = Flux.just("hi", "big");
        flux.doOnNext(str -> System.out.println("doOnNext"))
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("finish"));
        // 创建一个 Flux，该 Flux 会以固定的时间间隔发出元素
        Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1));
        intervalFlux.take(2).subscribe(System.out::println);
        // 试图阻塞直到最后一个元素发出，但由于这是一个无限流，实际上会一直阻塞
        // intervalFlux.blockLast();

        // 每隔1秒发出一个元素
        Flux<Long> fluxOne = Flux.interval(Duration.ofMillis(1000))
                // 会在背压时丢弃元素
                .onBackpressureDrop()
                // 一次申请10个数据项
                .doOnSubscribe(subscription -> subscription.request(10));
        fluxOne.subscribe(
                        data -> System.out.println("Received:" + data),
                        error -> System.out.println("Error:" + error),
                        () -> System.out.println("Completed")
                );
        // 获取1个，然后阻塞
        fluxOne.take(1).blockLast();

        // generate 创建复杂的序列1
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);
        // generate 创建复杂的序列2
        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 2) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
        // create 创建复杂的序列
        Flux.create(sink -> {
            for(int i = 0; i < 10; i ++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);

    }

}
