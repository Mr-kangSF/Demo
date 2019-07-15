package com.wankang.demo.service.java8;

import com.wankang.demo.dto.Trader;
import com.wankang.demo.dto.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-14 23:16
 **/
public class StreamTest04 {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        test01(transactions);
//        test02(transactions);
//        test03(transactions);
//        test04(transactions);
//        test05(transactions);
//        test06(transactions);
//        test07(transactions);
        test08(transactions);

    }

    // 找到交易额最小的交易
    private static void test08(List<Transaction> transactions) {
        transactions.stream().sorted(Comparator.comparing(Transaction::getValue)).findFirst().ifPresent(System.out::println);

        // 法2
        transactions.stream()
                .reduce((t1, t2) ->
                        t1.getValue() < t2.getValue() ? t1 : t2);

        // 法3
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }

    // 所有交易中， 最高的交易额是多少
    private static void test07(List<Transaction> transactions) {
        Integer reduce = transactions.stream().map(Transaction::getValue).reduce(0, Math::max);
        System.out.println(reduce);
    }

    // 打印生活在剑桥的交易员的所有交易额    (求和？)
    private static void test06(List<Transaction> transactions) {
        Integer cambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);

        System.out.println(cambridge);
    }

    // 有没有交易员是在米兰工作的
    private static void test05(List<Transaction> transactions) {
        boolean milan = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));

        System.out.println(milan);
    }

    // 返回所有交易员的姓名字符串，按字母顺序排序
    private static void test04(List<Transaction> transactions) {
        List<String> collect1 = transactions.stream()
                .map(Transaction::getTrader)
                .map(trader -> trader.getName())
//                .map(name -> name.split(""))
//                .flatMap(Arrays::stream)
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        System.out.println(collect1);
    }

    // 查找所有来自于剑桥的交易员，并按姓名排序
    private static void test03(List<Transaction> transactions) {
        List<Trader> cambridge = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(Trader -> Trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        System.out.println(cambridge);
    }

    // 交易员都在哪些不同的城市工作过
    private static void test02(List<Transaction> transactions) {
        List<String> collect2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect2);
    }

    // 找出2011年发生的所有交易，并按交易额排序（从低到高）
    private static void test01(List<Transaction> transactions) {
        List<Transaction> collect = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(collect);
    }


}
