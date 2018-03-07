export class Reimbursement {
    r_id: number;
    amount: number;
    date_submitted: Date;
    date_resolved: Date;
    description: string;
    author: number;
    resolver: number;
    status: number;
    type: number;

    constructor(id: number = 0, amount: number = 0, date_submitted: Date = null, date_resolved: Date = null,
        description: string = '', author: number = 0, resolver: number, status: number,
        type: number) {
        this.r_id = id;
        this.amount = amount;
        this.date_submitted = date_submitted;
        this.date_resolved = date_resolved;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.status = status;
        this.type = type;
    }
}
