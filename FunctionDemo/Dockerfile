# Nativeビルド
FROM ghcr.io/graalvm/graalvm-ce:latest as build-image

WORKDIR "/task"
COPY ./ ./ 
#COPY ~/.m2 /root/.m2

# Native Build
RUN ./mvnw clean package -D skipTests -P lambda -f pom.xml

FROM public.ecr.aws/lambda/provided:al2
COPY --from=build-image /task/src/shell/bootstrap ${LAMBDA_RUNTIME_DIR}
COPY --from=build-image /task/target/function-demo ${LAMBDA_TASK_ROOT}

CMD ["org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest"]

# # Custom runtime on Amazon Linux 2にデプロイ
# FROM amazon/aws-lambda-provided:al2

# WORKDIR ${LAMBDA_TASK_ROOT}

# # COPY --from=build-image /task/target/bootstrap ${LAMBDA_RUNTIME_DIR}
# COPY --from=build-image /task/src/shell/bootstrap ${LAMBDA_RUNTIME_DIR}
# COPY --from=build-image /task/target/function-demo ${LAMBDA_TASK_ROOT}
# # 起動時のハンドラを指定
# CMD ["org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest"]

# # ビルドイメージからzipをコピー
# COPY --from=build-image /task/target/function-demo-1.0.0-native-zip.zip ${LAMBDA_TASK_ROOT}

# # unzipのインストール
# RUN yum update -y && yum upgrade -y
# RUN yum install unzip -y

# # zipの解凍
# # bootstrapシェルスクリプトとfucntion-demoバイナリ実行ファイルが${LAMBDA_TASK_ROOT}に作成される
# RUN unzip function-demo-1.0.0-native-zip.zip

# # Debug
# RUN echo $(ls -a1 ${LAMBDA_TASK_ROOT})

# # bootstrapファイルのみ指定の${LAMBDA_RUNTIME_DIR}へコピー
# COPY ${LAMBDA_TASK_ROOT}/bootstrap ${LAMBDA_RUNTIME_DIR}

# # 起動時のハンドラを指定
# CMD ["org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest"]



# COPY --from=build-image /task/target/bootstrap ${LAMBDA_RUNTIME_DIR}
# COPY --from=build-image /task/target/function-demo ${LAMBDA_TASK_ROOT}
# # COPY --from=build-image /task/target/*.zip ${LAMBDA_TASK_ROOT}
# WORKDIR ${LAMBDA_TASK_ROOT}
# COPY ./target/function-demo-1.0.0-native-zip.zip ./

# COPY ./target/bootstrap /var/runtime/bootstrap
# COPY ./target/function-demo /var/runtime/function-demo
# COPY ./target/bootstrap ${LAMBDA_RUNTIME_DIR}
# COPY ./target/function-demo ${LAMBDA_TASK_ROOT}


# # RUN echo $(ls -1 ${LAMBDA_TASK_ROOT})
#RUN yum update -y && yum upgrade -y
#RUN yum install zip unzip -y

# 解凍
# bootstrapシェルスクリプトとfucntion-demoバイナリ実行ファイルが${LAMBDA_TASK_ROOT}に作成される
# RUN unzip function-demo-1.0.0-native-zip.zip

# bootstrapファイルのみ指定の${LAMBDA_RUNTIME_DIR}へコピー
# fucntion-demoバイナリ実行ファイルは${LAMBDA_TASK_ROOT}でOK
# https://hub.docker.com/r/amazon/aws-lambda-provided
## Copy custom runtime bootstrap
##COPY bootstrap ${LAMBDA_RUNTIME_DIR}
## Copy function code
##COPY function.sh ${LAMBDA_TASK_ROOT}
#COPY ${LAMBDA_TASK_ROOT}/bootstrap ${LAMBDA_RUNTIME_DIR}

# RUN echo $(ls -a1 ${LAMBDA_TASK_ROOT})
# COPY ${LAMBDA_TASK_ROOT}/bootstrap /var/runtime/
# COPY ${LAMBDA_TASK_ROOT}/function-demo /var/runtime/
# # COPY ./ /var/runtime/
#RUN echo $(ls -a1 /var/runtime/)

#COPY --from=build-image /task/target/classes /var/task/
#COPY --from=build-image /task/target/dependency /var/task/lib
#RUN jar -xvf FunctionDemo-0.0.1-SNAPSHOT-aws.jar
# Command can be overwritten by providing a different command in the template directly.
# https://www.creationline.com/lab/39662
# 起動時のハンドラを指定
#CMD ["org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest"]