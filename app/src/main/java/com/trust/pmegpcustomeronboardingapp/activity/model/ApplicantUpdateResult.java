package com.trust.pmegpcustomeronboardingapp.activity.model;

public class ApplicantUpdateResult {

        private boolean success;
        private String message;

        public ApplicantUpdateResult() {
        }

        public ApplicantUpdateResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        // Getters and Setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "ApiResponse{" +
                    "success=" + success +
                    ", message='" + message + '\'' +
                    '}';
        }

}
