import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description'should send a approved message'
    label 'triggerApprovedMessage'

    input {
        triggeredBy("triggerApprovedMessage()")
    }
    outputMessage {
        sentTo 'approvals'
        body([approvalStatus: "APPROVED"])
    }

}