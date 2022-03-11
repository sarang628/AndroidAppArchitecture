# UI 레이어 개요 따라만들기
https://srandroid.tistory.com/412

안드로이드 앱 아키택처 문서와 예제코드를 이해하기위해 만든 프로젝트 입니다.

## Flow.map()
transform이라고하는 변환을 해주는 기능이 있습니다. 

수도꼭지에서 물이 흐른다고 가정했을때 중간에 샤워호스를 연결하면 다른 형태의 모양으로 물이 흐르는 것처럼
물은 같은 값을 보내지만 중간에 변경시켜 변경된 값이 보내지는 기능으로 이해했습니다.

```
/**
 * Returns a flow containing the results of applying the given [transform] function to each value of the original flow.
 * 원래 flow의 각 값에 주어진 [변환] 함수를 적용한 결과를 포함하는 flow을 반환합니다.
 */
public inline fun <T, R> Flow<T>.map(crossinline transform: suspend (value: T) -> R): Flow<R> = transform { value ->
    return@transform emit(transform(value))
}
```
