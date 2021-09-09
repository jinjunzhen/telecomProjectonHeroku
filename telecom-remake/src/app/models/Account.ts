import Plan from "./Plan";

class Account{
    account_id!: number;
    log_in_email! : string;
    log_in_pass_word! : string;
    plans!: Plan[];

    // constructor(id = 0, email = '', password = '', plans=[]) {
    //     this.account_id = id;
    //     this.log_in_email = email;
    //     this.log_in_pass_word = password;
    //     this.plans = plans;
    // }
}
export default Account;