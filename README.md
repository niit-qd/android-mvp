# android-mvp
a mplementation of MVP resolution in Android platform

---


1. 泛型设计依据
    本MVP模式，逻辑处理的出发点是`View`层。所以，所有的泛型设计，都应该从`View`层展开。
    - `View`层
        指定所有的泛型类型。其它层不能创建新的泛型，只能是来自于`View`层。        
        目前，`View`层实现是`Activity`和`Fragment`。
        而且，由于当前框架使用了[生命周期感知型组件](https://developer.android.google.cn/topic/libraries/architecture/lifecycle?hl=zh-cn)，所以，本框架的实现实际上是基于[LifecycleOwner](https://developer.android.google.cn/reference/androidx/lifecycle/LifecycleOwner?hl=en).
    - `Presenter`层
        是`View`层的依附，更明确的说法是`View`层的代理，所有的控制都抽象在`Presenter`层。各个泛型类型来源于`View`层的制定，与`View`层之间的泛型关系比较密切。
    - `Model`层
        和`Presenter`层类似的地方主要是概念上的关系，是`View`层的依附。但是泛型关联不是很强。
        在对`ViewBinding`的扩展中，`ViewBinding`的类型来源于`View`层

2. `Presenter`回调时机
    1. `Activity`
        - 初始化：`FullLifecycleObserver#onCreate(LifecycleOwner)`
        - 释放：`FullLifecycleObserver#onDestroy(LifecycleOwner)`
    2. `Fragment`
        1. 以`Fragment`作为基础进行处理`FullLifecycleObserver`生命周期
            *注：不推荐这种方案，仅供有兴趣的同学参考对比使用。*
            ```Java
            // 在任何生命周期之前调用
            setLifecycleOwnerType(LifecycleOwnerType.FRAGMENT);
            ```
            - 初始化：`IFragmentPresenter#onCreateView(LifecycleOwner)`
            - 释放：`IFragmentPresenter#onDestroyView(LifecycleOwner)`
        2. 以`View`作为基础进行处理`FullLifecycleObserver`生命周期
           **注：推荐这种方案。 参考说明：[Fragment#getViewLifecycleOwner()](https://developer.android.google.cn/reference/androidx/fragment/app/Fragment#getViewLifecycleOwner())**
            ```Java
            // 在任何生命周期之前调用
            setLifecycleOwnerType(LifecycleOwnerType.VIEW);
            ```
            - 初始化：`FullLifecycleObserver#onCreate(LifecycleOwner)`
            - 释放：`FullLifecycleObserver#onDestroy(LifecycleOwner)`

3. 使用方法
    参考`app`模块中的示例即可。
4. 不足
    - View层和Presenter层，在泛型依赖上存在相互依赖问题，所以无法正常解耦。