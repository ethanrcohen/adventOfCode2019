load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_binary")


kt_jvm_library(
    name="aoc_lib",
    srcs=glob(["*.kt"]),
    data=glob(["inputFiles/*.txt"])
)

java_binary(
    name = "Problem1",
    main_class = "src.Problem1",
    runtime_deps=[":aoc_lib"]
)

java_binary(
    name="Problem2",
    main_class="src.Problem2",
        runtime_deps=[":aoc_lib"]
)
