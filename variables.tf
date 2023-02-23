variable "PROJECT_NAME" {
  type    = string
  description = "Project Name to create resources with a project reference"
}

variable "PROJECT_ENVIRONMENT" {
  type    = string
  description = "Environment (dev, stg, prod)"
}

variable "aws_region" {
  type    = string
  description = "AWS Region where we deploy resources"
}

variable "AWS_ACCOUNT_ID" {
  type    = string
  description = "AWS Account ID"
}

variable "LUMIGO_TRACER_TOKEN" {
  type = string
  description = "Lumigo Tracer Token"
}

variable "SPRING_PROFILES_ACTIVE" {
  type = string
  description = "Spring Profile active"
}

variable "JAVA_TOOL_OPTIONS" {
  type = string
  description = "Java Tool Options"
}

variable "LUMIGO_MAX_ENTRY_SIZE" {
  type = string
  description = "Lumigo Max Entry Size"
}

variable "AWS_ACCESS_KEY_ID" {
  type = string
  description = "AWS Access Key"
}

variable "AWS_SECRET_ACCESS_KEY" {
  type = string
  description = "AWS Secret Access Key"
}

variable "MONGODB_URI" {
  type = string
  description = "Mongo Cluster URI"
}

variable "MONGODB_DATABASE" {
  type = string
  description = "Mongo Database name"
}

variable "CORS_ORIGIN_IP" {
  type = string
  description = "CORS ORIGIN IP"
}

variable "RABBITMQ_IP" {
  type = string
  description = "RabbitMQ service IP"
}

variable "RABBITMQ_PORT" {
  type = string
  description = "RabbitMQ service Port"
}

variable "RABBITMQ_USERNAME" {
  type = string
  description = "RabbitMQ service Username"
}

variable "RABBITMQ_PASSWORD" {
  type = string
  description = "RabbitMQ service Password"
}

variable "RABBITMQ_MACHINE_ID_QUEUE" {
  type = string
  description = "RabbitMQ service Queue"
}

variable "MACHINE_ONCUBE_USERNAME" {
  type = string
  description = "Oncube username"
}

variable "MACHINE_ONCUBE_PASSWORD" {
  type = string
  description = "Oncube password"
}

variable "MACHINE_ONCUBE_ADDRESS" {
  type = string
  description = "Oncube Address"
}

variable "HTTP_RESPONSE_BODY_SIZE_MAX" {
  type = string
  description = "HTTP Response Body size max"
}

variable "MACHINE_ONCUBE_VIZEN_IMAGES_PATH" {
  type = string
  description = "Machine Oncube Vizen Images Path"
}

variable "AWS_LAMBDA_FUNCTION_NAME" {
  type = string
  description = "Function name"
}

variable "AWS_LAMBDA_ACCESS_KEY" {
  type = string
  description = "Function Access Key"
}

variable "AWS_LAMBDA_SECRET_KEY" {
  type = string
  description = "Function Secret Key"
}

variable "AWS_LAMBDA_CENTERS_FUNCTION_NAME" {
  type = string
  description = "Function Secret Key"
}

variable "AWS_LAMBDA_FUNCTION_AUTH_NAME" {
  type = string
  description = "Function Lambda Auth"
}

variable "SAVIOO_API_URL" {
  type = string
  description = "API Savioo URL"
}

