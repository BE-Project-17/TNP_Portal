import { Company } from "./company.model"

export class Job{
    id: string
    role: string
    ctc: number
    registration_end_date_time: string
    ssc: number
    hsc: number 
    cgpa: number
    skills: string[]
    ugBranch: string[]
    pgBranch: string[]
    gender: string
    company: Company
}