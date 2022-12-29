# Practice Module

## WebFlux



## MapStruct

의존성 추가

```
implementation 'org.mapstruct:mapstruct:1.5.3.Final'
annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.3.Final'
```

### 추상화

1단계

추상화가 스탭을 많이 밟은 상태로 implement 해서 진행할 경우에는 커스터마이징이 어렵다는 단점이 있다.

위 링크에서는 추상화가 진행된 상태이기 때문에 자세한 구현사항을 반영할 수 없다.

그러므로 직접 구현하기 위해서는 MapperInterface를 구현하여 mapping을 직접 지정해주고,

다양한 매핑 방식을 적용하는 편이 좋을 것 같다.(ignore, src→des, target→constant)
